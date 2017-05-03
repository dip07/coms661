package com.dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.models.BookOld;
import com.models.Books;
import com.models.Books.Book;
import com.models.Course;
import com.models.CourseList;
import com.models.Instructors;
import com.models.Instructors.Instructor;
import com.models.Roles;
import com.models.Roles.Role;
import com.models.Users;
import com.models.Users.User;
import com.models.VoteForms;
import com.models.VoteForms.VoteForm;
/**
 * 
 * @author gbhatt
 *
 */
public class VoteXmlDbDao {
	
	@Value("${dbFiles.location}")
	private String dbFilesLocation;
	
	Logger logger= Logger.getLogger(VoteXmlDbDao.class);
	
	
	/**
	 * @param instructorForm
	 * @return
	 */
	public Boolean saveAdminVoteData(VoteForm voteForm) {
		
		VoteForms voteForms= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(VoteForms.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"adminVoteData.xml");
			voteForms = (VoteForms) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			voteForms= new VoteForms();
			voteForms.setVoteFormList(new ArrayList<VoteForms.VoteForm>());
			e.printStackTrace();
		}
		voteForms.getVoteFormList().add(voteForm);

		Marshaller jaxbMarshaller;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(VoteForms.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File existingFile= new File(dbFilesLocation+"adminVoteData.xml");
			jaxbMarshaller.marshal(voteForms, existingFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Function to get details of all Votes
	 * @param voteForm
	 * @return
	 */
	public ArrayList<VoteForm> getAllVotes(VoteForms voteForm) {
		
		VoteForms voteForms= null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(VoteForms.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File existingFile= new File(dbFilesLocation+"adminVoteData.xml");
			voteForms = (VoteForms) jaxbUnmarshaller.unmarshal(existingFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(voteForms == null){
			return null;
		}
		
		return voteForms.getVoteFormList();
	}
}
