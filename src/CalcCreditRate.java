import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class CalcCreditRate {

    private int iSumCredit ;
    private double dPersFeeYear ;
    private int iTimePeriod ;

    public CalcCreditRate(int iSumCreditL, double dPersFeeYearL, int iTimePeriodL){
        iSumCredit = iSumCreditL ;
        dPersFeeYear = dPersFeeYearL ;
        iTimePeriod = iTimePeriodL ;
    }

    public CalcCreditRate(){

    }

    public void set_iSumCredit(int iSumCreditLoc){
        iSumCredit = iSumCreditLoc ;
    }

    public int getiSumCredit(){
        return iSumCredit ;
    }

    public static void main(String[] args) throws Exception {


        void inputParameters() {
            boolean bUseStandartInterval = 0 ;
            int[] miTimePeriods = {} ;
            int iSumCreditL = 0 ;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите примерную сумму кредита: ");
            iSumCreditL = Integer.parseInt(reader.readLine());
            System.out.print("Введите расчетную процентную ставку: ");
            double dPersFeeYearL = Double.parseDouble(reader.readLine());
            miTimePeriods = {12, 36, 60};

            boolean bUseStandartTimeLine = false;
            boolean bCorrectSymbol = false;
            String sel = "";
            System.out.print("Использовать для расчета стандартные интервалы времени: 12, 36 и 60  месяцев? (Ответ Y или N) ");
            while (!bCorrectSymbol) {
                sel = reader.readLine();
                if (1 == sel.length()) {
                    if (sel.equals("Y") || sel.equals("N"))
                        bCorrectSymbol = true;
                    else
                        System.out.print("Повторите ввод (неправильный  символ): ");
                } else
                    System.out.print("Повторите ввод (слишком много символов): ");
            }
            if (sel.equals("Y"))
                bUseStandartTimeLine = true;

            if (!bUseStandartTimeLine) {
//            System.out.println("Стандартные интервалы");
//            int iQtyMonths[] = new int[3] ;
//            iQtyMonths[] = ;
                System.out.print("Введите планируемую продолжительность кредита в месяцах: ");
                int iQty = Integer.parseInt(reader.readLine());
                miTimePeriods = new int[1];
                miTimePeriods[0] = iQty;
            }
        }

        void createObjects(){
            for (int i = 0; i < miTimePeriods.length; i++) {
                CalcCreditRate ccr = new CalcCreditRate(miTimePeriods[i]);
                ccr.calculatingCreditParameter();
                if (1 == i) {
                    CalcCreditRate ccr1 = new CalcCreditRate(miTimePeriods[i]);
                    ccr1.calculatingCreditParameter();
                }
                else if (2 == i) {
                    CalcCreditRate ccr2 = new CalcCreditRate(miTimePeriods[i]);
                    ccr2.calculatingCreditParameter();
                }
            }
        }
    }

    public void calculatingCreditParameter(){
        for (int i = 0; i < miTimePeriods.length; i++) {
            double dPercentFeeMonth = dPersFeeYear / 100 / 12;
            double dPercenthMonthWidthrawal = iSumCredit * dPercentFeeMonth;
            double dCreditMonthWidthrawal = dPercentFeeMonth + (dPercentFeeMonth / (Math.pow((1 + dPercentFeeMonth), iQtyMonths[i]) - 1)) * iSumCredit;
            double dCreditMonthPayCalc = iSumCredit * (dPercentFeeMonth + (dPercentFeeMonth / (Math.pow((1 + dPercentFeeMonth), iQtyMonths[i]) - 1)));
            double dMonthPay = dPercenthMonthWidthrawal + dCreditMonthWidthrawal;

            System.out.println("Берем кредит в размере: " + iSumCredit + "руб. на срок " + iQtyMonths[i] + " мес. с процентной ставкой " + dPercentFeeYear + "% годовых");
            System.out.println("Ежемесячный платеж составит: " + dMonthPay);


            double dSumCredit = (double) iSumCredit;
            short iStep = (short) iQtyMonths[i];
            double dPercentTotal = 0.0;
            DecimalFormat df = new DecimalFormat("#.##");
            while (iStep > 0) {
                dPercenthMonthWidthrawal = Math.round((dSumCredit * dPercentFeeMonth) * 100.0) / 100.0;
                dCreditMonthWidthrawal = Math.round((dPercentFeeMonth + (dPercentFeeMonth / (Math.pow((1 + dPercentFeeMonth), iStep) - 1)) * dSumCredit) * 100.0) / 100.0;
//            dCreditMonthPayCalc = iSumCredit * (dPercentFeeMonth + (dPercentFeeMonth / (Math.pow((1 + dPercentFeeMonth),iQtyMonths) - 1))) ;
                dMonthPay = dPercenthMonthWidthrawal + dCreditMonthWidthrawal;
                dSumCredit = dSumCredit - dCreditMonthWidthrawal;

                dPercentTotal = dPercentTotal + dPercenthMonthWidthrawal;

                System.out.println(iStep + "\t" + df.format(dMonthPay) + "\t" + df.format(dPercenthMonthWidthrawal) + "\t" + df.format(dCreditMonthWidthrawal));
                iStep--;
//            System.out.println(Math.round(dMonthPay * 100.0) / 100.0);
            }
            System.out.println();
            System.out.println("Переплата по кредиту составит: " + df.format(dPercentTotal) + " руб. Эффективная процентная ставка: " + (Math.round(100 * (dPercentTotal / (double) iSumCredit)) * 10000.0) / 10000.0 + "%");
        }
    }
}
