package org.jmotor.model;

/**
 * TeamMemberDataBase is the basic database.
 * Define the Statistics generation in Team's member database.
 * 
 * @author zhuhui
 * @createDate 2017-12-13
 */
public class TeamMemberDataBase {
    private Integer id;
	private String vsName;
    private String groupName;
    private String memberName;
    private String memberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getVSName() {
        return vsName;
    }

    public void setVSName(String vsName) {
        this.vsName = vsName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
	

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public static class Builder 
	{
        private Integer id;
		private String vsName;
        private String groupName;
        private String memberName;
        private String memberId;

        public Builder id(Integer id) 
		{
            this.id = id;
            return this;
        }
		
		public Builder vsName(String vsName) 
		{
            this.vsName = vsName;
            return this;
        }

        public Builder groupName(String groupName) 
		{
            this.groupName = groupName;
            return this;
        }

        public Builder memberName(String memberName) 
		{
            this.memberName = memberName;
            return this;
        }

        public Builder memberId(String memberId) 
		{
            this.memberId = memberId;
            return this;
        }

        public TeamMemberDataBase build() 
		{
            TeamMemberDataBase teamMemberData = new TeamMemberDataBase();
            teamMemberData.setId(id);
			teamMemberData.setVSName(vsName);
			teamMemberData.setGroupName(groupName);
            teamMemberData.setMemberName(memberName);
            teamMemberData.setMemberId(memberId);
            return teamMemberData;
        }

        public static Builder newBuilder() 
		{
            return new Builder();
        }
    }
}
