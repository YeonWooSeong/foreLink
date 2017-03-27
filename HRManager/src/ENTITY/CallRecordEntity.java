package ENTITY;

public class CallRecordEntity {		//통화내역 객체 클래스
	private String callDate;
	private String callContents;
	private String callAvailDate;
	private int no;			// 통화내역 직원 번호 값
	private int recordNo; //통화내역 구분 값
	
	public CallRecordEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getCallDate() {
		return callDate;
	}

	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}

	public String getCallContents() {
		return callContents;
	}

	public void setCallContents(String callContents) {
		this.callContents = callContents;
	}
	
	public String getCallAvailDate() {
		return callAvailDate;
	}

	public void setCallAvailDate(String callAvailDate) {
		this.callAvailDate = callAvailDate;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
}