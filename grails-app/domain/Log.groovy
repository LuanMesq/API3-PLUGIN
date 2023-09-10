import java.time.LocalDate
import com.fasterxml.jackson.annotation.JsonFormat
import grails.gorm.annotation.Entity

@Entity
class Log {

    Long id
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate data
    String descricao

    static mapping = {
        id generator: "increment"
        version false
    }

    static constraints = {
        data nullable: false
        descricao nullable: false, maxSize:  1000
        id  unique: true
    }
}
