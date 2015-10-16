package bankonet.dto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
	
public @interface ToString {
	boolean uppercase() default false;
}
