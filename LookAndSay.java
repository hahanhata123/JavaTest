import java.util.Scanner;

/**
* Look-and-say calc
* by SCIT
*/

class LookAndSay{
	private int totalNumbers;
	private String[] numbers;
	
	public String[] getNumbers(){
		return numbers;
	}
	public LookAndSay(int totalNumber){
		this.totalNumbers = totalNumber;
		numbers = new String[totalNumber];
		numbers[0] = "1";
	}	
	
  public String getNumAtPos(int pos, String num){
    return num.substring(pos,pos+1);
  }
    
  public int getNumOfNum(int pos, String num){
    String inputNum = getNumAtPos(pos,num);
    int value = 0;
    boolean found = false;
    int count = pos;
    while (!found && count<num.length()){
      String nextNum = getNumAtPos(count,num);
      if (inputNum.equals(nextNum)){
        value++;
        count++;
      }else{
        found = true;
      }
    }
    return value;
  }

    
  public void calc(){
    String finalNumber = "1";
    for (int i = 1;i<totalNumbers;i++){
      int j=0;
      String num = "";
      while (j<finalNumber.length()){
      	num += getNumOfNum(j,finalNumber)+getNumAtPos(j,finalNumber);
      	j+= getNumOfNum(j,finalNumber);
      }
      finalNumber = num;
      numbers[i] = num;
    }
  }
  public long[] getSumOfEachNum(){
    long[] sum = new long[totalNumbers];
    for (int i=0;i<totalNumbers;i++){
      long sumEachNum = 0;
      String num = numbers[i];
      while (num.length()>0){
        int subNum = Integer.valueOf(num.substring(num.length()-1,num.length()));
        num = num.substring(0,num.length()-1);
        sumEachNum += subNum;
      }
      sum[i] = sumEachNum;
    }
    return sum;
  }
}
