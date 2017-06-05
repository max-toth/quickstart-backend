package quickstart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mtolstyh
 * @since 25.01.2017.
 */
@Document
@Getter
@Setter
@AllArgsConstructor
public class QuickStartEntity {
    @Id
    private String id;

    private Object data;
}
