package com.ablicq.pokerGame;

import com.ablicq.pokerGame.deckTests.DeckTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(DeckTest.class)
public class GlobalTestSuite {
}
