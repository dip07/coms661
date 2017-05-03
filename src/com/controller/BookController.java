package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BookXmlDbDao;
import com.models.BookOld;
import com.models.Books;
import com.models.Books.Book;
import com.models.Course;
import com.models.CourseList;

import constants.CourseBookMessages;

@Controller
public class BookController 
{
	@Autowired
	BookXmlDbDao xmlDbDao;
	
	@Value("${dbFiles.location}")
	private String dbFilesLocation;
	
	Logger logger= Logger.getLogger(BookController.class);

	//@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'><h3>Hello Message</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	/**
	 * welcome screen
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/welcome")
	public ModelAndView hello(HttpServletRequest request,HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("welcome");
		return model;
	}

	/**
	 * This page is used to fetch book details.
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/fetchBook")
	public ModelAndView fetchBook(HttpServletRequest request,HttpServletResponse response,Model modelObj) throws Exception {

		ModelAndView model = new ModelAndView("book");
		model.addObject("message", "From fetchBook function");
		modelObj.addAttribute("bookForm", new BookOld());
		return model;
	}

	/**
	 * This is used to get all the details regarding a book
	 * @param book : object of class BookOld.
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/getBookData")
	public ModelAndView getBookData(@ModelAttribute("bookForm") BookOld book , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		ModelAndView modelObj = new ModelAndView("book");
		logger.debug("Got value from form :" + book.getBookName());
		modelObj.addObject("newMessage", "Got details");
		model.addAttribute("studentFormstudentForm", new BookOld());
		ArrayList<BookOld> bookObj=xmlDbDao.getBookDataFromDb(book);
		for(BookOld instance:bookObj)
			logger.warn(instance);
		model.addAttribute("isDataPresent", true);
		model.addAttribute("bookObj", bookObj);
		return modelObj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This is used to get the edited details of any book
	 * @param book : Object of Class BookOld
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/viewEditBookData")
	public ModelAndView enterBookData(@ModelAttribute("bookForm") BookOld book , HttpServletRequest request,HttpServletResponse response,Model model) throws Exception 
	{
		try{
		ModelAndView modelObj = new ModelAndView("book");
		//logger.warn("Got value from form :" + book.getBookName());
		modelObj.addObject("newMessage", "Got details");
		model.addAttribute("studentFormstudentForm", new BookOld());
		ArrayList<BookOld> bookObj=xmlDbDao.getBookDataFromDb(book);
		for(BookOld instance:bookObj)
			logger.warn(instance);
		model.addAttribute("isDataPresent", true);
		model.addAttribute("bookObj", bookObj);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    CourseList courseList= null;
	    try{
	    	File existingFile= new File(dbFilesLocation+"course.xml");
	    	courseList = (CourseList) jaxbUnmarshaller.unmarshal(existingFile);
	    }
	    catch(Exception e)
	    {
	    	courseList= new CourseList();
	    	courseList.setCourses(new ArrayList<Course>());
	    	e.printStackTrace();
	    }
	    model.addAttribute("courseList", courseList);
		return new ModelAndView("editBookData");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * this is used to get all details of a book
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/getBook")
	public ModelAndView getBookInformation(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("enterBookPage");
		Books.Book bookObj= new Books.Book();
		bookObj.setCourseNumber("535");
		bookObj.setInstructorName("Gaurav Bhatt");
		bookObj.setSession("Spring");
		bookObj.setYear(2017);
		modelObj.addAttribute("bookForm", bookObj);
		return model;
	}
	
	/**
	 * This is used to store the book information
	 * @param book : Object of Class Book
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/saveBook")
	public ModelAndView saveBookInforation(@ModelAttribute("bookForm") Books.Book book,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("enterBookPage");
		return model;
	}
	
	/**
	 * This is used to display all book details
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/showAllBookDetails")
	public ModelAndView showAllBookDetails(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("showAllBookDetailsPage");
		ArrayList<Book> bookList= xmlDbDao.getAllBookDetails();
		if(bookList!=null)
			modelObj.addAttribute("courseBooks", bookList);
		else
			modelObj.addAttribute("noData", true);
		return model;
	}
	
	/**
	 * Utility to export data to an excel file
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/exportToExcel")
	public ModelAndView exportToExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ArrayList<Book> bookList= xmlDbDao.getAllBookDetails();
		if(bookList!=null)
		{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Book Details");
			
			CellStyle style = workbook.createCellStyle();
		    Font font = workbook.createFont();
		    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    font.setFontHeightInPoints((short)14);
		    font.setFontName("Courier New");
		    style.setFont(font);
		    
			Map<String, Object[]> data = new HashMap<String, Object[]>();
			data.put("1", new Object[] {"Course Number","Year","Session","Instructor Name","Book Name","Author Name"
					,"ISBN","Comments"});
			int count=1;
			for(Book book : bookList)
			{
				count++;
				data.put(String.valueOf(count), new Object[]{book.getCourseNumber(),Double.valueOf(book.getYear()), book.getSession(),
						book.getInstructorName(), book.getBookName(), book.getAuthor(),
						book.getISBN(),book.getComments()}
						);
			}
			Set<String> keyset = data.keySet();
			int rownum = 0;
			for (String key : keyset) 
			{
				Row row = sheet.createRow(rownum++);
				row.setHeightInPoints(15);
				Object [] objArr = data.get(key);
				int cellnum = 0;
				for (Object obj : objArr) 
				{
					Cell cell = row.createCell(cellnum++);
					if(obj instanceof Date) 
						cell.setCellValue((Date)obj);
					else if(obj instanceof Boolean)
						cell.setCellValue((Boolean)obj);
					else if(obj instanceof String)
						cell.setCellValue((String)obj);
					else if(obj instanceof Double)
						cell.setCellValue((Double)obj);
					cell.setCellStyle(style);
					
				}
			}
			try {
				String home = System.getProperty("user.home");
				File file = new File(home+"/Downloads/" + "BookInfo" + ".xls");
				FileOutputStream out = 
						new FileOutputStream(file);
				workbook.write(out);
				out.close();
				System.out.println("Excel written successfully..");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/showAllBookDetails");
	}
	
	/**
	 * This is used to add new book details
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/addNewBookDetails")
	public ModelAndView addNewBookDetails(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("addNewCourseBook");
		String userNetId = request.getSession().getAttribute("bookUserNetId").toString();
		String userName = request.getSession().getAttribute("bookUserName").toString();
		String status = xmlDbDao.getAuthorizedCourseInfo(userNetId,userName);
		
		logger.debug("status is "+ status);
		
		if(status.equalsIgnoreCase(CourseBookMessages.NO_INSTRUCTOR_INFO_ASSIGNED.toString()))
			modelObj.addAttribute("message", CourseBookMessages.NO_INSTRUCTOR_INFO_ASSIGNED.toString());
		
		else if (status.equalsIgnoreCase(CourseBookMessages.NO_COURSE_ASSIGNED.toString()))
			modelObj.addAttribute("message", CourseBookMessages.NO_COURSE_ASSIGNED.toString());
		
		else if (status.equalsIgnoreCase(CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString()))
			modelObj.addAttribute("message", CourseBookMessages.COURSE_INFO_ALREADY_FILLED.toString());
		else
		{
			String courseNumbers[] = status.split("-");
			ArrayList<String> courseNumLis = new ArrayList<String>(Arrays.asList(courseNumbers));
			modelObj.addAttribute("courseNumLis", courseNumLis);
		}
		modelObj.addAttribute("bookForm", new Books.Book());
		return model;
	}
	
	/**
	 * This is used to save details of a course book
	 * @param book : Object of Class Book
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/saveCourseBook")
	public ModelAndView saveCourseBook(@ModelAttribute("bookForm")Book book ,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("redirect:/showAllBookDetails");
		model.addObject("message", "Custom message from Controller");
		logger.debug("Received book info " + book.toString());
		xmlDbDao.saveCourseBookInfo(book);
		modelObj.addAttribute("bookForm", new Books.Book());
		return model;
	}
	
	/**
	 * This is used to edit book information
	 * @param courseNumber : course number as a string
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/editCourseBookInfo")
	public ModelAndView editCourseBook(@RequestParam(value="courseNumber") String courseNumber,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("addNewCourseBook");
		logger.debug("Received courseNumber " + courseNumber);
		Book book = xmlDbDao.getCourseBookInfo(courseNumber);
		modelObj.addAttribute("bookForm", book);
		ArrayList<String> courseNumLis = new ArrayList<String>(Arrays.asList(courseNumber));
		modelObj.addAttribute("courseNumLis", courseNumLis);
		return model;
	}
	
	/**
	 * Instructor's home page
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/getInstructorHomePage")
	public ModelAndView instuctorHomePage(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("instructorHomePage");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Integer> yearList= new ArrayList<Integer>();
		for(Integer i=year;i> (year - 5) ;i--)
			yearList.add(i);
		modelObj.addAttribute("yearList", yearList);
		return model;
	}
	
	/**
	 * This is used to get old book details
	 * @param year : Year information as a String
	 * @param session : Session information as a String
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/getOldCourseBookInfo")
	public ModelAndView getOldCourseBookInfo(@RequestParam(value="year") String year,@RequestParam(value="session") String session,HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("oldCourseBookPage");
		logger.debug("Received year " + year  + " session " + session);
		ArrayList<Book> oldCourseBookList = xmlDbDao.getOldCourseBook(Integer.parseInt(year),session);
		if(oldCourseBookList == null || oldCourseBookList.isEmpty())
			modelObj.addAttribute("noData", true);
		else
			modelObj.addAttribute("oldBooksList", oldCourseBookList);
		return model;
	}
	
	/**
	 * This will be used to archive all book details
	 * @param request : HTTP servlet request 
	 * @param response : HTTP servlet response
	 * @param modelObj : Interface that defines a holder for model attribute
	 * @return
	 * @throws Exception : Any exception that may occur.
	 */
	@RequestMapping("/archiveAllCourseBook")
	public ModelAndView archiveAllCourseBook(HttpServletRequest request,HttpServletResponse response, Model modelObj) throws Exception {
		
		ModelAndView model = new ModelAndView("redirect:/adminScreen");
		Boolean done = xmlDbDao.archiveAllCourseBook();
		if(done!=null && done){
			return new ModelAndView("redirect:/adminScreen?archived=t");
		}
		return model;
	}
}
