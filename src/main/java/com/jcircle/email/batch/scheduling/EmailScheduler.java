package com.jcircle.email.batch.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.jcircle.email.batch.config.AwsConfig;

@Component("emailScheduler")
public class EmailScheduler {

	private String bucket;
	private AmazonS3 amazonS3;
	@Value("${aws.main.bucket.folder.name}")
	private String folderName;

	public EmailScheduler(AwsConfig awsConfig) {
		this.amazonS3 = awsConfig.getAWSS3Client();
		bucket = awsConfig.getBucket();
	}

	/**
	 * This method always gets invoked for every 2 second, always makes sure the
	 * previous task is complete
	 */
	@Scheduled(fixedDelayString = "${fixed-delay.in.milliseconds}")
	public void checkS3FilesCountInSeconds() {

		System.out.println("Fixed delay in seconds - " + System.currentTimeMillis() / 1000);
	}

	@Scheduled(cron = "${cron.expression}")
	public void checkS3FilesCountInMinute() {

		System.out.println("Fixed delay in minute - " + System.currentTimeMillis() / 1000);
		System.out.println("Bucket----:" + bucket);
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucket)
				.withPrefix(this.folderName + "/");
		ObjectListing objects = this.amazonS3.listObjects(listObjectsRequest);

		List<S3ObjectSummary> summaries = objects.getObjectSummaries();

		if (summaries.size() >= 20) {
			// Trigger the email functionality
			System.out.println("----Size exceeded the total count----" + summaries.size());

		}
		// summaries.forEach(s -> System.out.println(s.getKey()));
		// objects = this.amazonS3.listNextBatchOfObjects(objects);

	}

}
