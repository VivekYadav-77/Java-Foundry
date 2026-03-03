// Raw code not good yet it will get efficient one soon
import java.util.Arrays;
public class CountSort {
    public static int MaxorMin(int []oa,boolean isMax){
        int num = oa[0];
        for(int i =1;i<oa.length;i++){
            if(isMax?oa[i]>num:oa[i]<num){
                num = oa[i];
            }
        }
        return num;
    }
    public static void freqArrPref(boolean isPrefixArray,int []oa,int max,int []fa){
        if(!isPrefixArray){
            for(int i =0;i<oa.length;i++){
                fa[max-oa[i]]+=1;
            }
            return;
        }
        for(int i =1;i<fa.length;i++){
            fa[i]=fa[i-1]+fa[i];
        }
        for(int i =0;i<fa.length;i++){
            fa[i]-=1;
        }
        return;
    }
    public static void fillingfun(int []oa,int []fa,int max){
        int []temp = new int[oa.length];
        for(int i = oa.length-1;i>-1;i--){
          
             temp[fa[(max-oa[i])]]=oa[i];
             fa[(max-oa[i])]-=1;
        }
        for(int j =0;j<oa.length;j++){
            oa[j]=temp[j];
        }
        return;
    }
    public static void main(String [] args){
        int []oa={8,4,2,4,2,3,2,8,5,3,5,4,7,6,8,7};
        int max = MaxorMin(oa, true);
        int min = MaxorMin(oa, false);
        int []fa= new int[max-min+1];
        freqArrPref(false,oa,max,fa);
        freqArrPref(true,oa,max,fa);
        System.out.println("fa"+Arrays.toString(fa));
        fillingfun(oa,fa,max);
        System.out.println("here is array"+Arrays.toString(oa));

    }
}
