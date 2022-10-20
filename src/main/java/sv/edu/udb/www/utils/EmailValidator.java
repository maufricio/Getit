package sv.edu.udb.www.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("sv.edu.udb.www.utils.EmailValidator")
public class EmailValidator implements Validator {
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    /**
     * <a href="http://www.mkyong.com/regular-expressions/how-to-validate-email
     * -address-with-regular-expression/">Source</a> <br/>
     * Modification : autorisation des "-" dans le nom de domaine <br/>
     * Exemple valide : jean-michel-75440.exemple42@email-pro.mon-entreprise.com
     */
    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        /* Create the correct mask */
        Pattern mask = Pattern.compile(EMAIL_REGEX);

        /* Get the string value of the current field */
        String emailField = (String) value;

        /* Check to see if the value is a valid email */
        Matcher matcher = mask.matcher(emailField);

        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage();
            message.setSummary("Email no valido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
