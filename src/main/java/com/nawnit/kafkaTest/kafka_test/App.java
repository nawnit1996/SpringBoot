package com.nawnit.kafkaTest.kafka_test;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nawnit.kafkaTest.kafka_test.model.Address;
import com.nawnit.kafkaTest.kafka_test.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JsonProcessingException {
		System.out.println("Hello World!");
		Address address = new Address(1, "Banka", "this is line 1");
		Student student = new Student(1, "Nawnit Sen", address);
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        ObjectMapper  objectMapper =new ObjectMapper();
		Producer<String, byte[]> producer = new KafkaProducer<String, byte[]>(props);
		producer.send(new ProducerRecord<String, byte[]>("newTestTopic", Integer.toString(address.getId()),
				objectMapper.writeValueAsBytes(student)));

		producer.close();
	}
}
