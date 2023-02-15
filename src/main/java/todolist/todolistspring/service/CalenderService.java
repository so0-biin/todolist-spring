package todolist.todolistspring.service;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalenderService {
    public boolean checkLeapYear(int year){
        if(year%400 == 0) {
            return true;
        }
        else if(year%100 == 0) {
            return false;
        }
        else if(year%4==0) {
            return true;
        }
        else {
            return false;
        }
    }

    public  int getFirstDayOfWeek(int year, int month){ // 각 달의 1일이 무슨 요일인지
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    public ArrayList<String> changeYearMonth(int year, int month){
        int[] month_day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(month==2){
            if(checkLeapYear(year)==true) month_day[1] = 29;
        }

        int first_day_of_week = getFirstDayOfWeek(year, month);
        ArrayList<String> arr_calender = new ArrayList<String>();
        //달력에 1일부터 채우기
        for(int i=1; i<first_day_of_week; i++){ //월요일==1
            arr_calender.add("");
        }
        for(int i=1; i<=month_day[month-1]; i++){
            arr_calender.add(String.valueOf(i));
        }

        int remain_day = 7 - (arr_calender.size()%7);

        if(remain_day<7) {
            for(int i=0; i<remain_day; i++){
                arr_calender.add("");
            }
        }

        return arr_calender;
    }
}
