package com.kwon1.sb;

public class BoardVo { //Object 상속
	
	
	private int i_board;
	private String title;  //절대 private해 public은 아니야 우선순위 떄문에
	private String content;
	private String regDateTime;
	
	/* public BoardVo() {} */ //기본생성자 쓰지 못하게 막음
	
	public BoardVo(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	/*
	 * public BoardVo(int i, String a, String b, String c) { i_board = i; title = a;
	 * content = b; regDateTime = c; }
	 */
	public BoardVo(int i_board, String title, String content, String regDateTime) {		
		this.i_board = i_board;
		this.title = title;
		this.content = content;
		this.regDateTime = regDateTime;
	}
		
	//메소드를 통해서 넣고 뺸다. set get 
	
	
	public int getI_board() {
		return i_board;
	}

	

	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	
	public String getTilte() {
		return title;
	}
	

	public void setTilte(String tilte) {
		this.title = tilte;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	
	//생성자를 통해 넣는다. 빼기 X 
	
	/*
	 * public BoardVo() { //리턴타입 X 클래스명이랑 이름이 같다.
	 * 
	 * }
	 */
	
	
	
		

}
