public class User {
	private String user;
	private String password;

	public User(String user, String password) {
		this.user = user;
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		User o = (User) obj;
		return (this.getUser().equals(o.getUser()) && this.getPassword().equals(o.getPassword()));
	}
	@Override
	public int hashCode() {
		return this.getUser().hashCode() + this.getPassword().hashCode();
	}
}
