import java.util.*;

public class CalculatorTesting {

    public static void main(String[] a){ 
         
        // Part A: Retirement planning 
        //test case 1 
        double pensionTarget = 240000; 
        double currentSaving = 0; 
        double annualSalary = 40000; 
        double monthlySaving = 0.1; 
        double interestRate = 0.04;  
         
        PensionPlanner fp = new PensionPlanner(pensionTarget, currentSaving,  
                        annualSalary, monthlySaving, interestRate); 
                                 
        System.out.println("Example: Test case 1 working months: " + fp.getWorkingMonth()); 
 
        assert fp.getWorkingMonth() == 368:"Failed test case 1";  
         
        // test case 2 
        fp.setPensionTarget(500000); 
        fp.setAnnualSalary(40000); 
        fp.setMonthlySaving(0.2); 
        assert fp.getWorkingMonth() == 377:"Failed test case 2";  
         
        // test case 3 
        fp.setPensionTarget(500000); 
        fp.setAnnualSalary(80000); 
        fp.setMonthlySaving(0.15); 
        assert fp.getWorkingMonth() == 295:"Failed test case 3"; 
         
        // Part B: Saving with a raise 
        // test case 4 
        double semiAnnualRaise = 0.03; 
        fp.setPensionTarget(240000); 
        fp.setAnnualSalary(40000); 
        fp.setMonthlySaving(0.1); 
        fp.setSemiAnnualRaise(semiAnnualRaise); 
        assert fp.getWorkingMonth() == 255:"Failed test case 4"; 
         
        // test case 5 
        fp.setPensionTarget(500000); 
        fp.setAnnualSalary(40000); 
        fp.setMonthlySaving(0.2); 
        fp.setSemiAnnualRaise(0.06); 
        assert fp.getWorkingMonth() == 199:"Failed test case 5";  
 
        // test case 6 
        fp.setPensionTarget(500000); 
        fp.setAnnualSalary(80000); 
        fp.setMonthlySaving(0.15); 
        fp.setSemiAnnualRaise(0.05); 
        assert fp.getWorkingMonth() == 179:"Failed test case 6"; 
         
        // Part C: Delaying withdrawal  
        // test case 7 
        fp.setWorkingMonth(360); // work for 30 years 
        fp.setAnnualSalary(40000); 
        fp.setMonthlySaving(0.1); 
        fp.setSemiAnnualRaise(0.03); 
        fp.setNoOfMonthDelay(36); // 3 years delay in withdrawal 
        System.out.println("Example: Test case 7 additional pension saving: " + fp.getAdditionalPensionSaving()); 
         
        // accept tolerance up to 100 in absolute value 
        assert Math.abs(fp.getAdditionalPensionSaving()-63454) <= 100: "Failed test case 7";  
        // Making about RM21k per year, even without any contribution in the 3 years 
         
        // test case 8 
        fp.setInterestRate(0.06); 
        assert Math.abs(fp.getAdditionalPensionSaving()-126469) <= 100: "Failed test case 8";  
        // Investment return raised from 4% to 6% will double up the additional saving from RM63k to RM126k 
            
        // test case 9 
        fp.setAnnualSalary(60000); 
        fp.setMonthlySaving(0.15); 
        fp.setNoOfMonthDelay(60); // 5 years delay in withdrawal 
        assert Math.abs(fp.getAdditionalPensionSaving()-474259) <= 100: "Failed test case 9";  
        // Almost RM100k per year, it is like having another fulltime job without having to work on it. 
 
        System.out.println("The quiz is done!"); 
        System.out.println("Submission code: PensionPlanner class ONLY."); 
        System.out.println("\nImportant:"); 
        System.out.println("DO NOT SUBMIT Quiz2 class!"); 
        System.out.println("DO NOT SUBMIT Quiz2 class!"); 
        System.out.println("DO NOT SUBMIT Quiz2 class!"); 
 
    }// main
}// class

/*
 * Node: To enable assertion in Java:
 * Compile by javac Quiz2.java
 * Execute by java -ea Quiz2
 * Refer to Lecture01 if you do know how to compile and execute by command lines
 * 
 * DO NOT SUBMIT THIS FILE
 */
