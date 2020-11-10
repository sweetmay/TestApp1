package com.sweetmay.testapp.utils
import org.threeten.bp.DateTimeException
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit
import java.util.*

class DateFormatter {
    companion object{
        private val dateFormats = arrayOf("yyyy-MM-dd", "dd-MM-yyyy")
        private val dateFormatOut: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ROOT)

        fun getFormattedDate(string: String?): String?{
            if(string!=null){
                for(format in dateFormats){
                    try {
                        val dateTimeFormatter = DateTimeFormatter.ofPattern(format, Locale.ROOT)
                        val date = LocalDate.parse(string, dateTimeFormatter)
                        return date.format(dateFormatOut)
                    } catch (e: DateTimeException){
                    }
                }
                return null
            }else {
                return null
            }
        }

        fun getAgeByBirthday(string: String?): String{
            if(string!=null){
                val birthday = LocalDate.parse(getFormattedDate(string), dateFormatOut)
                val now = LocalDate.now()
                val years = ChronoUnit.YEARS.between(birthday, now)
                return "$years y.o"
            }else{
                return ""
            }
        }
        }
}