package todoListAPI.model;


public class todoList {
	
	private long id;
	
	private String title;
	
	private String description;
	
	private String dueDate;
	
	public todoList(){
		id = 0;
	}
	
	public todoList(long id, String title, String description, String dueDate){
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		todoList other = (todoList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", title=" + title + ", tescription=" + description + ", dueDate=" + dueDate
				+ "]";
	}
}
