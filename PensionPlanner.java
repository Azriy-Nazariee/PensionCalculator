// BEGIN ANSWER Quiz2 <-- Copy From This Line 
// Submission code: PensionPlanner class  
import java.util.*;

public class PensionPlanner {
    
    private double pensionTarget; // money - in RM
    private double currentSaving; // money - in RM
    private double annualSalary; // money - in RM
    private double monthlySaving; // percentages - in decimal
    private double interestRate = 0.04; // percentages - in decimal
    private double semiAnnualRaise; // percentages - in decimal
    private int WorkingMonth; // month
    private double AdditionalPensionSaving; // money - in RM
    private int NoOfMonthDelay; // month
    
    
    public PensionPlanner(double pensionTarget, double currentSaving, double annualSalary, double monthlySaving, double interestRate) {
        this.pensionTarget = pensionTarget;
        this.currentSaving = currentSaving;
        this.annualSalary = annualSalary;
        this.monthlySaving = monthlySaving;
        this.interestRate = interestRate;
    }

    public void resetCurrentSaving() {
        currentSaving = 0;
    }
    

    public int getWorkingMonth() {
        resetCurrentSaving();
        int month = 0;
        double finalWorkingSaving;

        // calculating pension saving while works
        while (currentSaving <= pensionTarget) {

            // factor semi anual raise
            if (month % 6 == 0 && month != 0) {
                annualSalary += annualSalary * semiAnnualRaise;
            }

            //saving while working
            currentSaving += (currentSaving * (interestRate / 12)) + ((annualSalary / 12) * monthlySaving);

            month++;
        }
        return month;
    }

    public double getAdditionalPensionSaving(){ // saving for the period of working month + delayed withdrawal - only for interest
        
        resetCurrentSaving();
        double salary = annualSalary;
       
        //calculating saving while working
        int month = 0;
        while(month < WorkingMonth){

            // factor semi anual raise
            if (month % 6 == 0 && month != 0) {
                salary += salary * semiAnnualRaise;
            }

            currentSaving += (currentSaving * (interestRate / 12));
            currentSaving += ((salary / 12) * monthlySaving);

            month++;

        }

        double currentSaving_retired = currentSaving;
         
        int month_retired = 0; // month after retired

        while(month_retired< NoOfMonthDelay){ 
            currentSaving_retired += (currentSaving * (interestRate / 12));
            month_retired++;
        }

        AdditionalPensionSaving = currentSaving_retired - currentSaving;
        return AdditionalPensionSaving;

    }
    
    public void setPensionTarget(double pensionTarget) {
        this.pensionTarget = pensionTarget;
    }
    
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
    
    public void setMonthlySaving(double monthlySaving) {
        this.monthlySaving = monthlySaving;
    }
    
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setSemiAnnualRaise(double semiAnnualRaise) {
        this.semiAnnualRaise = semiAnnualRaise;
    }

    public void setNoOfMonthDelay(int NoOfMonthDelay) {
        this.NoOfMonthDelay = NoOfMonthDelay;
    }

    public void setWorkingMonth(int WorkingMonth) {
        this.WorkingMonth = WorkingMonth;
    }
}
// END ANSWER Quiz2 <-- Copy Until This Line
