package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mathtest {

	//范围距离中心点每辐射1公里 增加0.29元
	//两中心聚合点(113.25,23) (113.75,23)
	static float j1=113.25f;
	static float j2=113.75f;
	static float w1=23f;
	static float w2=23f;
	public static void main(String[]args){
		
		System.out.println("输入任意字符");
		Scanner input =new Scanner(System.in);
		String location ="";
		List<String>str_list=new ArrayList<String>();
		while(!location.equals("end")){
			location=input.nextLine();
			if(!location.equals("end")){
			str_list.add(location);}
		}
		for(String lo:str_list){
			String[]total=lo.split(",");
			float jd_write = Float.valueOf(total[0]);
			float wd_write = Float.valueOf(total[1]);
			float j_dis1=jd_write-j1;
			float w_dis1=wd_write-w1;
			float j_dis2=jd_write-j2;
			float w_dis2=wd_write-w1;
			if(j_dis1<0){
				j_dis1=-j_dis1;
			}
			if(w_dis1<0){
				w_dis2=-w_dis2;
			}
			if(j_dis2<0){
				j_dis2=-j_dis2;
			}
			if(w_dis2<0){
				w_dis2=-w_dis2;
			}
			float dis1=(j_dis1*91291/1000)*(j_dis1*91291/1000)+(w_dis1*110950/1000)*(w_dis1*110950/1000);
			double dis1_answer=Math.sqrt(dis1)*0.29+62.5;
			float dis2=(j_dis2*91291/1000)*(j_dis2*91291/1000)+(w_dis2*110950/1000)*(w_dis2*110950/1000);
			double dis2_answer=Math.sqrt(dis2)*0.29+62.5;
			if(dis1_answer>=dis2_answer){
				System.out.println(dis2_answer+"元");
			}else{
				System.out.println(dis1_answer+"元");
			}
		}
		
		
	}

}
