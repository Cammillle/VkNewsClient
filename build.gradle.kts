// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("vkid.manifest.placeholders") version "1.1.0" apply true
}

vkidManifestPlaceholders {
    // Добавьте плейсхолдеры сокращенным способом. Например, vkidRedirectHost будет "vk.ru", а vkidRedirectScheme будет "vk$clientId".
    init(
        clientId = "54140439",
        clientSecret = "OfunRXeJ6vh43d2PnhoW",
    )
    // Или укажите значения явно через properties, если не хотите использовать плейсхолдеры.
    vkidRedirectHost = "vk.ru" // Обычно vk.ru.
    vkidRedirectScheme = "vk1233445" // Строго в формате vk{ID приложения}.
    vkidClientId = "54140439"
    vkidClientSecret = "OfunRXeJ6vh43d2PnhoW"
}