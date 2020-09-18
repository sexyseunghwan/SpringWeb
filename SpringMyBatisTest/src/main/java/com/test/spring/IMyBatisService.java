package com.test.spring;

import java.util.HashMap;

public interface IMyBatisService {

	void m1();

	int m2(String seq);

	int m3(HashMap<String, String> map);

	int m4(MyBatisDTO dto);

}
