package x.app.utils.safecommand

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.axonframework.commandhandling.CommandHandler
import x.app.common.AbstractCommand
import x.app.common.AbstractResult
import x.app.common.ExceptionResult

/**
 *   @Project: safe-command-handler
 *   @Package: x.app.utils.safecommand
 *   @Author:  Iamee
 *   @Date:    2019-05-02 22:36
 */
@Aspect
class SafeCommand {

    @Around("@annotation(commandHandler) && args(command)")
    fun safeHandle(joinPoint: ProceedingJoinPoint, commandHandler: CommandHandler, command: AbstractCommand<*>): AbstractResult {
        return try {
            joinPoint.proceed() as AbstractResult
        } catch (ex: Throwable) {
            ExceptionResult(ex)
        }
    }

}