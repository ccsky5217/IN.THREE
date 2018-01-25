package org.jmotor.restlet;


import org.jmotor.model.TeamMemberDataBase;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
/**
 * StacksRestlet is the RestAPI interface.
 * 
 * Statistics generation in Team's member database :
 * Periodically, each TeamMemberDataBase entry process stores statistics 
 * counters in the database 
 * 
 * Statistics extraction from database :
 * Periodically, a user can extract statistics reports from the database. 
 * For a selected team name key, the extraction is the result of stored in the 
 * database.
 * 
 * @author zhuhui
 * @createDate 2017-12-13
 */
@Path("v1/neo/hackathon/IN")
public class TeamMemberDataBaseRestlet {
	
    static List<TeamMemberDataBase> datalist = new ArrayList<TeamMemberDataBase>();
	static
    {
		datalist.add(TeamMemberDataBase.Builder.newBuilder().id(1).vsName("ISDK VStream").groupName("Flash ScreamTeam").memberName("Zhu Hui").memberId("61455265").build());
		datalist.add(TeamMemberDataBase.Builder.newBuilder().id(2).vsName("NE3S-WS VStream").groupName("Halo ScreamTeam").memberName("Larry Liu").memberId("61465322").build());

    }
    

    @GET
    @Produces("application/json")
    public List<TeamMemberDataBase> getAllTeamMember() 
	{
    	System.out.println("--------------Search all team members----------");
		System.out.println("Team member number is: " + datalist.size());
		return datalist;
//        return Arrays.asList(
//                TeamMemberDataBase.Builder.newBuilder().id(1).vsName("ISDK VStream").groupName("Flash ScreamTeam").memberName("Zhu Hui").memberId("61455265").build(),
//                TeamMemberDataBase.Builder.newBuilder().id(2).vsName("NE3S-WS VStream").groupName("Halo ScreamTeam").memberName("Larry Liu").memberId("61465322").build()
//        );
        

    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public TeamMemberDataBase getSinglTeamMember(@NotNull @PathParam("id") Integer id) 
	{
		System.out.println("--------------Search team members----------");
        switch (id) {
            case 1:
                return TeamMemberDataBase.Builder.newBuilder().id(1).vsName("ISDK VStream").groupName("Flash ScreamTeam").memberName("Zhu Hui").memberId("61455265").build();
            case 2:
                return TeamMemberDataBase.Builder.newBuilder().id(2).vsName("NE3S-WS VStream").groupName("Halo ScreamTeam").memberName("Larry Liu").memberId("61465322").build();
            default:
                throw new WebApplicationException("NEO Hackathon I.N Team do not have the according member, id: " + id, 404);
        }
    }
	
	@POST
    @Path("add")
    @Produces("application/json")
	@Consumes("application/json")
	public List<TeamMemberDataBase> addTeamMember(TeamMemberDataBase dataBean) 
	{
		System.out.println("--------------Add a new team member----------");

	    Integer id = 0;
		String vsName = null;
	    String groupName = null;
	    String memberName = null;
	    String memberId = null;

		if (null != dataBean)
		{
			System.out.println("dataBean is not null");
			
			if(null != dataBean.getId())
			{
				System.out.println(dataBean.getId().toString());
				id = dataBean.getId();
			}
			else
			{
				System.out.println("ID is null");
			}
			
			if(null != dataBean.getVSName())
			{
				System.out.println(dataBean.getVSName());
				vsName = dataBean.getVSName();
			}
			else
			{
				System.out.println("VSName is null");
			}
			
			if(null != dataBean.getGroupName())
			{
				System.out.println(dataBean.getGroupName());
				groupName = dataBean.getGroupName();
			}
			else
			{
				System.out.println("GroupName is null");
			}
			
			if(null != dataBean.getMemberName())
			{
				System.out.println(dataBean.getMemberName());
				memberName = dataBean.getMemberName();
			}
			else
			{
				System.out.println("MemberName is null");
			}
			
			if(null != dataBean.getMemberId())
			{
				System.out.println(dataBean.getMemberId());
				memberId = dataBean.getMemberId();
			}
			else
			{
				System.out.println("MemberId is null");
			}
			
		}
		else
		{
			System.out.println("dataBean is null");
		}

		datalist.add(TeamMemberDataBase.Builder.newBuilder().id(id).vsName(vsName).groupName(groupName).memberName(memberName).memberId(memberId).build());
		System.out.println("Team member number is: " + datalist.size());
//		System.out.println(id);
//		System.out.println(vsName);
//		System.out.println(groupName);
//		System.out.println(memberName);
//		System.out.println(memberId);
		return datalist;

    }
	
	    @DELETE
    @Path("/delete/{id}")
    @Produces("application/json")
    public List<TeamMemberDataBase> deleteTeamMember(@NotNull @PathParam("id") Integer id) {
    	 System.out.println("--------------Delete a team member----------");
         System.out.println("delete : id = " + id);
         for (TeamMemberDataBase dataBean : datalist)
         {
        	 if(dataBean.getId() == id)
        	 {
        		 datalist.remove(dataBean);
        	 }
         }
         
         System.out.println("Team member number is: " + datalist.size());
         return datalist;
    } 
    
    @PUT
    @Path("update")
    @Produces("application/json")
	@Consumes("application/json")
    public List<TeamMemberDataBase> updateTeamMember(TeamMemberDataBase dataBean) 
    {
        //dbMap.put(user.getId(), user);  
		System.out.println("--------------Update a new team member----------");
	    Integer id = 0;
		String vsName = "default";
	    String groupName = "default";
	    String memberName = "default";
	    String memberId = "default";
	    
		if (null != dataBean)
		{
			System.out.println("dataBean is not null");
			
			if(null != dataBean.getId())
			{
				System.out.println(dataBean.getId().toString());
				id = dataBean.getId();
			}
			else
			{
				System.out.println("ID is null");
			}
			
			if(null != dataBean.getVSName())
			{
				System.out.println(dataBean.getVSName());
				vsName = dataBean.getVSName();
			}
			else
			{
				System.out.println("VSName is null");
			}
			
			if(null != dataBean.getGroupName())
			{
				System.out.println(dataBean.getGroupName());
				groupName = dataBean.getGroupName();
			}
			else
			{
				System.out.println("GroupName is null");
			}
			
			if(null != dataBean.getMemberName())
			{
				System.out.println(dataBean.getMemberName());
				memberName = dataBean.getMemberName();
			}
			else
			{
				System.out.println("MemberName is null");
			}
			
			if(null != dataBean.getMemberId())
			{
				System.out.println(dataBean.getMemberId());
				memberId = dataBean.getMemberId();
			}
			else
			{
				System.out.println("MemberId is null");
			}
			
		}
		else
		{
			System.out.println("dataBean is null");
		}
		
        for (TeamMemberDataBase datalistBean : datalist)
        {
	       	 if(datalistBean.getId() == id)
	       	 {
	       		 datalist.remove(datalistBean);
	       		 datalist.add(TeamMemberDataBase.Builder.newBuilder().id(id).vsName(vsName).groupName(groupName).memberName(memberName).memberId(memberId).build());
	       	 }
        }
		
        System.out.println("Team member number is: " + datalist.size());
        return datalist;
    }
	
	
}
