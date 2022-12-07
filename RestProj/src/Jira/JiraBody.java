package Jira;

public class JiraBody 
{
	public static String creteJiraIssueBody()
	{
		return "{\r\n"
				+ "  \"fields\": \r\n"
				+ "  {\r\n"
				+ "    \"project\": \r\n"
				+ "    {\r\n"
				+ "      \"key\": \"TES\"\r\n"
				+ "    },\r\n"
				+ "    \"summary\": \"Credit card\",\r\n"
				+ "    \"description\":\"Testing\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "      \"name\": \"Task\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
	}
	public static String AddingComment(String comment)
	{
		return "{\r\n"
				+ "    \"body\": \""+comment+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}
}
