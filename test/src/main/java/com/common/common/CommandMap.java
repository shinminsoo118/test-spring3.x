package com.common.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 * 클래스는 별다른 부분은 없다. 내부적으로 Map을 하나 생성하고, 그 맵에 모든 데이터를 담는 역할을 한다.
 * 여기서 중요한점은 절대로 Map을 상속받으면 안된다.
 * Map을 상속받게 되면 우리가 작성할 ArgumentResolver를 거치지 않게 되니 주의하자.
 * 여러가지 메서드들이 보이는데, 거의 대부분은 map의 기본기능을 다시 호출하는것에 지나지 않는다.보통 가장 많이 사용
 * 하는 get,put메서드만 잇어도 큰 문제는 없겠지만 여기서는 필자가 생각할때 필요한 맵의 기능들을 몇가지 골라서 추가했다.
 * 
 * */
public class CommandMap {
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	public Object get(String key){
		return map.get(key);
	}
	
	public void put(String key, Object value){
		map.put(key, value);
	}
	
	public Object remove(String key){
		return map.remove(key);
	}
	
	public boolean containsKey(String key){
		return map.containsKey(key);
	}
	
	public void clear(){
		map.clear();
	}
	
	public Set<String> keySet(){
		return map.keySet();
	}
	
	public boolean isEmpty(){
		return map.isEmpty();
	}
	
	public void putAll(Map<? extends String, ?extends Object> m){
		map.putAll(m);
	}
	
	public Map<String, Object> getMap(){
		return map;
	}
	
}
