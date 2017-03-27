package ENTITY;

public class FileEntity {
	private int employeeNo;
	private String fileName;
	private String fileSize;
	private String fileType;
	private String fileAddress;
	private int fileNo;
	
	public FileEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public String getFileType() {
		return fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public String getFileAddress() {
		return fileAddress;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
}
