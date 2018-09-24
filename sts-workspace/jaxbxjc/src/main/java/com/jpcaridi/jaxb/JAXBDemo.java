package com.jpcaridi.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jpcaridi.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("jcaridi");
			
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(patient, stringWriter);
			
			System.out.println(stringWriter.toString());
			
			Unmarshaller unmarchaller = context.createUnmarshaller();
			
			Patient patientResult = (Patient)unmarchaller.unmarshal(new StringReader(stringWriter.toString()));
			System.out.println(patientResult.getName());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
