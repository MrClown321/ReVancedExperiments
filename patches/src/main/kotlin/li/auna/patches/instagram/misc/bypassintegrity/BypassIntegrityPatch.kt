package li.auna.patches.instagram.misc.bypassintegrity

import app.revanced.patcher.patch.bytecodePatch
import li.auna.util.returnEarly

@Suppress("unused")
val signatureCheckPatch = bytecodePatch(
    name = "Disable signature check",
    description = "Disables the signature check that causes the app to crash on startup."
) {
    compatibleWith("com.instagram.android"("378.0.0.52.68"))

    execute {
        isValidSignatureMethodFingerprint
            .match(isValidSignatureClassFingerprint.classDef)
            .method
            .returnEarly(true)
    }
}