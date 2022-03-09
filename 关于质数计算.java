public class 关于质数计算 {
    public static void main(String[] args) {
        /**
        *默认计算时间需要19087
        *加break时间1865
        *使用开根和break为18
        *break 判断到可以整除不是质数后可以立即进行下一个数的判断,对非质数更快判断
        *Math.sqrt，1*9=9，2*4.5=9，3*3=9.俩数相乘得到一个数，开根数为最后一组数相乘，后面的为前面的重复。对质数可以更快的判断
        *set集合，质数是不可被除1和本身外分解，那么集合中储存质数，只要一个数不能被前面的质数整除，及为质数
        */
        boolean isflag = true;

        long time1 = time();
        //第一种方法
//        for (int i = 2; i<=100000;i++){
//            for (int j = 2; j < i; j++) {
//                if (i%j==0){
//                    isflag = false;
//                }
//            }
//            if (isflag==true){
//                System.out.println(i);
//            }else{
//                isflag = true;
//            }
//        }
        long time2=time();
        //第二种方法，使用break后
        isflag = true;
        long a =0L;
        for (int i = 2; i<=100000;i=i+1){
            for (int j = 2; j <i; j++) {
                if (i%j==0){
                    isflag = false;
                    break;
                }
            }
            if (isflag==true){
                a++;
//                System.out.println(i);
            }else{
                isflag = true;
            }
        }

        long time3 = time();
      //第三种方法，使用开根方法
        long b = 0L;
        for (int i = 2; i<=100000;i=i+1){
            for (int j = 2; j <=Math.sqrt(i); j++) {
                if (i%j==0){
                    isflag = false;
                    break;
                }
            }
            if (isflag==true){
                b++;
//                System.out.println(i);
            }else{
                isflag = true;
            }
        }
        long time4 = time();
      //使用set
        Set<Integer> set = new HashSet<Integer>();
        set.add(2);//把最小质数放入
        int c =1;
        for (int i = 2; i<=100000;i++){
            for (int j :set){
                if (i%j ==0){
                    isflag =false;
                    break;
                }
            }
            if (isflag==true){
                set.add(i);
                c++;
            }else {
                isflag=true;
            }
        }
        long time5 = time();
      
        System.out.println(".........");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(".........");
        System.out.println((time2-time1)+"\n"+(time3-time2)+"\n"+(time4-time3)+"\n"+(time5-time4)+"\n");


    }
    static Long time(){
        return System.currentTimeMillis();
    }
}
