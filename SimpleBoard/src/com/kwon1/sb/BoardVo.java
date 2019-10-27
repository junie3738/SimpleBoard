package com.kwon1.sb;

public class BoardVo {

	private String title;
	private String content;
		
	//메소드를 통해서 넣고 뺸다. set get 
	
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
	
	//생성자를 통해 넣는다. 빼기 X 
	
	/*
	 * public BoardVo() { //리턴타입 X 클래스명이랑 이름이 같다.
	 * 
	 * }
	 */
	
	public BoardVo(String a, String b) {
		title = a;
		content = b;
	}
	
		

}
