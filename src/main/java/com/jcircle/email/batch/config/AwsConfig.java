package com.jcircle.email.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Primary
@Configuration
@ConfigurationProperties(prefix = "aws.main")
public class AwsConfig {

	private String id;
	private String secret;
	private String region;
	private String bucket;

	public AmazonS3 getAWSS3Client() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(getId(), getSecret());

		return AmazonS3ClientBuilder.standard().withRegion(getRegion())
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

}
