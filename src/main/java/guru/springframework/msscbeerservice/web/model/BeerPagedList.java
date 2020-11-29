package guru.springframework.msscbeerservice.web.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jt on 2019-05-12.
 */
public class BeerPagedList extends PageImpl<BeerDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerPagedList(@JsonProperty("content") List<BeerDto> content,
                         @JsonProperty("number") int number,
                         @JsonProperty("size") int size,
                         @JsonProperty("totalElements") Long totalElements,
                         @JsonProperty("pageable") JsonNode pageable,
                         @JsonProperty("last") boolean last,
                         @JsonProperty("totalPages") int totalPages,
                         @JsonProperty("sort") JsonNode sort,
                         @JsonProperty("first") boolean first,
                         @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }

    public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerDto> content) {
        super(content);
    }
}

/*
(1)
@JsonCreator   very easy example here given

https://www.logicbig.com/tutorials/misc/jackson/json-creator.html
----------------------------------------------------------------------------

(2)

JsonCreator.Mode.PROPERTIES    <-- all Modes defined here
https://fasterxml.github.io/jackson-annotations/javadoc/2.5/com/fasterxml/jackson/annotation/JsonCreator.Mode.html

PROPERTIES
Mode that indicates that the argument(s) for creator are to be bound from matching
properties of incoming Object value, using creator argument names (explicit or implicit) to match
 incoming Object properties to arguments.
----------------------------------------------------------------------------------


(3)
JsonNode


https://developer.gnome.org/json-glib/stable/json-glib-JSON-Node.html

A JsonNode is a generic container of elements inside a JSON stream. It can contain fundamental
types (integers, booleans, floating point numbers, strings) and complex types (arrays and objects).
When parsing a JSON data stream you extract the root node and walk the node tree by retrieving the
 type of data contained inside the node with the JSON_NODE_TYPE macro. If the node contains a
 fundamental type you can retrieve a copy of the GValue holding it with the json_node_get_value()
 function, and then use the GValue API to extract the data; if the node contains a complex type
  you can retrieve the JsonObject or the JsonArray using json_node_get_object() or json_node_get_array()
  respectively, and then retrieve the nodes they contain.
A JsonNode may be marked as immutable using json_node_seal(). This marks the node and all its
 descendents as read-only, and means that subsequent calls to setter functions (such as json_node_set_array())
  on them will abort as a programmer error. By marking a node tree as immutable, it may be referenced in
   multiple places and its hash value cached for fast lookups, without the possibility of a value deep within
    the tree changing and affecting hash values. Immutable JsonNodes may be passed to functions which retain
     a reference to them without needing to take a copy.

JsonNode supports two types of memory management: alloc/free semantics, and ref/unref semantics.
The two may be mixed to a limited extent: nodes may be allocated (which gives them a reference count of 1),
referenced zero or more times, unreferenced exactly that number of times (using json_node_unref()),
 then either unreferenced exactly once more or freed (using json_node_free()) to destroy them.
  json_node_free() must not be used when a node mi
 */
