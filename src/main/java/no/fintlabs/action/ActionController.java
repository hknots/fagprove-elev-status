package no.fintlabs.action;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actionlog")
public class ActionController {

    private final List<ActionLog> actionLogs = new ArrayList<>();

    public void addActionLog(ActionLog actionLog) {
        actionLogs.add(actionLog);
    }

    @GetMapping
    public ResponseEntity<List<ActionLog>> getActionLogs() {
        return ResponseEntity.ok(actionLogs);
    }

}
