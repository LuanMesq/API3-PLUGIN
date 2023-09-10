
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Transactional
class LogService {

    def salvarLog(Map dadosLog) {
        Map retorno = [success: true]
        log.error("dadosLog: ${dadosLog}")
        Log novoLog = new Log(data: LocalDate.now(), descricao: dadosLog as String)
        log.error("novoLog: ${novoLog.descricao} ${novoLog.data}")

        try {
            log.error("Salvando....")
            novoLog.save(flush: true)
        } catch (Exception e) {
            log.error("Pauuu... ${e}")
            retorno.success = false
        }

        return retorno
    }
}
