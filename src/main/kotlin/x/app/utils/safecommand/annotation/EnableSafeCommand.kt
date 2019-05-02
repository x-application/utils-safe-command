package x.app.utils.safecommand.annotation

import org.springframework.context.annotation.Import
import x.app.utils.safecommand.SafeCommand

/**
 *   @Project: utils-safe-command
 *   @Package: x.app.utils.safecommand.annotation
 *   @Author:  Iamee
 *   @Date:    2019-05-02 22:50
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(SafeCommand::class)
annotation class EnableSafeCommand