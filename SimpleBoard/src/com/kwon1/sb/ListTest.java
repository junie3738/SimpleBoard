package com.kwon1.sb;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		/* List list = new ArrayList(); */
		List<BoardVo> list = new ArrayList();
		BoardVo vo = new BoardVo("", "");
		list.add(vo); 
		
		BoardVo obj1 = list.get(0);
		
		list.size();
		
		
	}

}
