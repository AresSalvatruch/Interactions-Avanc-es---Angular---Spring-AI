from mcp.server.fastmcp import FastMCP

mcp = FastMCP("python-mcp-server-test")

@mcp.tool()
def get_employee_info(name: str) -> dict:
    """
    Get Information about a given employee name:
    - Name
    - Salary
    """
    return {
        "employee_name": name,
        "salary": 5400,
    }

if __name__ == "__main__":
    mcp.run()
