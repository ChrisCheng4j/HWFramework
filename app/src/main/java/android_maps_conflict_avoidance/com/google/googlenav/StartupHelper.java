package android_maps_conflict_avoidance.com.google.googlenav;

import java.util.Vector;

public class StartupHelper {
    private static Vector startupCallbacksForBgThread;
    private static Vector startupCallbacksForUiThread;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android_maps_conflict_avoidance.com.google.googlenav.StartupHelper.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: android_maps_conflict_avoidance.com.google.googlenav.StartupHelper.<clinit>():void
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:46)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:98)
	... 5 more
Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1197)
	at com.android.dx.io.OpcodeInfo.getFormat(OpcodeInfo.java:1212)
	at com.android.dx.io.instructions.DecodedInstruction.decode(DecodedInstruction.java:72)
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:43)
	... 6 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android_maps_conflict_avoidance.com.google.googlenav.StartupHelper.<clinit>():void");
    }

    public static void addPostStartupBgCallback(Runnable runnable) {
        addPostStartupCallback(runnable, false);
    }

    private static void addPostStartupCallback(Runnable runnable, boolean needsUiThread) {
        synchronized (StartupHelper.class) {
            if (startupCallbacksForUiThread != null) {
                if (needsUiThread) {
                    startupCallbacksForUiThread.addElement(runnable);
                } else {
                    startupCallbacksForBgThread.addElement(runnable);
                }
                return;
            }
            runnable.run();
        }
    }
}
