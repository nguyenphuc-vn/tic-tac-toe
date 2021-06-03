package personal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EngineTest {
    //Logger logger = Logger.getLogger(EngineTest.class.getName());
    String input = "XXXOO__O_";
    String input1 = "XOXOXOXXO";
    String input2 = "XOXOOXOX ";
    String input3 ="XOXOOXXXO";
    Character [][]cells = new Character[3][3];
    Engine engine;

    @BeforeAll
    public void setup() {
        engine = new Engine();

    }

    @Test
    @DisplayName("1.Check state Full char grid")
    public void giveFullCharReturnTrue(){
        engine.setup(input1);
     //   assertTrue(engine.checkFinished());
    }
    @Test
    @DisplayName("2.Check state eight char grid")
    public void giveEightReturnFalse(){
        engine.setup(input2);
      //  assertFalse(engine.checkFinished());
    }

    @Test
    @DisplayName("3.Test first row")
    public void giveRowXReturn3X(){
        engine.setup(input1);
        //assertEquals("Game not finished",engine.checkStates());
    }

}