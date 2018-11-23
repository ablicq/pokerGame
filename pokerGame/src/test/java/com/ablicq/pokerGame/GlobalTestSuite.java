package com.ablicq.pokerGame;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.ablicq.pokerGame.deckTests", "com.ablicq.pokerGame.HandEvaluatorTest"})
public class GlobalTestSuite {
}
