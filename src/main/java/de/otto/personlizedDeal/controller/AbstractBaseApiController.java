package de.otto.personlizedDeal.controller;

import de.otto.personlizedDeal.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ConcurrentModificationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

public abstract class AbstractBaseApiController {

    private static final Pattern ENCLOSING_QUOTES_PATTERN = Pattern.compile("(^[\"])(.*)([\"]$)");

    public AbstractBaseApiController() {
    }

    @ExceptionHandler(ConcurrentModificationException.class)
    public ResponseEntity handleConcurrentModification() {
        return ResponseEntity.status(PRECONDITION_FAILED).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFound() {
        return ResponseEntity.status(NOT_FOUND).build();
    }

    protected String removeQuotes(final String stringWithQuotes) {
        if (isNull(stringWithQuotes)) {
            return null;
        }

        final Matcher m = ENCLOSING_QUOTES_PATTERN.matcher(stringWithQuotes);

        if (m.matches()) {
            return m.group(2);
        }

        return stringWithQuotes;
    }

    protected LinkedMultiValueMap<String, String> getETagHeader(final String eTag) {
        return new LinkedMultiValueMap<String, String>() {{
            add(HttpHeaders.ETAG, '"' + eTag + '"');
        }};
    }

    protected String cleanETag(final String etag) {
        if (isNull(etag)) {
            return null;
        }
        String result = etag.replaceAll("\"", "");
        result = result.replaceAll("W/", "");
        return result;
    }
}
