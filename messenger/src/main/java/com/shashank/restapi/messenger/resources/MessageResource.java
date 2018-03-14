package com.shashank.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shashank.restapi.messenger.model.Message;
import com.shashank.restapi.messenger.service.MessageService;

/*


Few other annotations that can be handy :
1. 	@PathParam("messageId")  
   	Sample Url : /messages/{messageId}
   	Usage : public Message getMessage(@PathParam("messageId") int messageId) { ... }
   	- Used to get the variable values in the path (URL)
 
2. 	@QueryParam("year")
   	Sample Url : /messages?year=2017
   	Usage : public List<Message> getMessages(@QueryParam("year") int year,
   											 @QueryParam("UserId") int userId) { ... }
   	- Used to get the query params (params after '?' in the url)
   	- cannot have a separate method to get these params. The method for '/messages' itself should be used.

3. 	@HeaderParam("userName")
   	Usage : public List<Message> getMessages(@HeaderParam("userName") String userName) { ... }
   	- Used to get the Header params in the request. Useful for authentication purposes.
   	
4.	@CookieParam("cookie")
	Usage : public List<Message> getMessages(@CookieParam("cookie") int cookie) { ... }

5. 	@BeanParam
	Usage : public List<Message> getMessages(@BeanParam MessageFilterBean mfb)
	- Can be used if there are too many queryParams to be obtained from the url.
	- Create a bean and add all the queryParams as class variables of that bean. 
	  Instance of this bean wil be the method param 
	Eg: class MessageFilterBean {
			private @QueryParam("year") int year;
			private @QueryParam("userId" int userid;
			
			// getters and setters
		}
		
6.	@Context
	Usage : public String getParamsUsingContxt(@Context UrlInfo urlInfo, @Context HttpHeaders headers) { ... }
	- Can get detailed UrlInfo and HttpHeaders details using these objects.

 */

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		for (Message msg : messageService.getMessages()){
			System.out.println(msg.getId() + " " + msg.getAuthor() + " " + msg.getMessage());
		}
		return messageService.getMessages();
	}
	
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	public Message remove(@PathParam("messageId") long id){
		return messageService.removeMessage(id);
	}
	
	

}
