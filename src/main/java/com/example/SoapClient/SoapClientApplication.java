package com.example.SoapClient;

import com.example.SoapClient.client.SOAPConnector;
import com.example.umesh.schemas.students.GetStudentDetailsRequest;
import com.example.umesh.schemas.students.GetStudentDetailsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			int id = 1;//Default Name
			if(args.length>0){
				id = Integer.valueOf(args[0]);
			}
			GetStudentDetailsRequest request = new GetStudentDetailsRequest();
			request.setId(id);
			GetStudentDetailsResponse response =(GetStudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/ws/students", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getStudentDetails().getName());


		};
	}

}
