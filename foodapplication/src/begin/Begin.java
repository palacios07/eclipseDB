package begin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.cloudant.client.api.Database;

import example.nosql.CloudantClientMgr;
import profile.Person;

@Path("/db/folder/")
public class Begin {

	@GET
	public Response saveData(@QueryParam("email") String email, @QueryParam("password") String password, @QueryParam("birthyear") int  birthyear, @QueryParam("zipcode") int  zipcode)
	{
		Person user = new Person();
		user.setEmail(email);
		user.setPassword(password);
		user.setBirthYear(birthyear);
		user.setZipCode(zipcode);
		
		Database db = CloudantClientMgr.getDB();
		db.save(user);
		
		return Response.status(200).entity("Connected "+email).build();
	}
	
	
	
}
