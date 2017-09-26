package com.everydapes.carnival.data;

import de.devland.esperandro.SharedPreferenceActions;
import de.devland.esperandro.SharedPreferenceMode;
import de.devland.esperandro.annotations.SharedPreferences;

@SharedPreferences(name = "com.everydapes.carnival", mode = SharedPreferenceMode.PRIVATE)
public interface AppPreferences extends SharedPreferenceActions {

}
