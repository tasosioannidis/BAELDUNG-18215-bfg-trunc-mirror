// Generated by jextract

package foreign.c;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
class constants$5 {

    static final FunctionDescriptor vprintf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle vprintf$MH = RuntimeHelper.downcallHandle(
        "vprintf",
        constants$5.vprintf$FUNC
    );
    static final FunctionDescriptor vsprintf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle vsprintf$MH = RuntimeHelper.downcallHandle(
        "vsprintf",
        constants$5.vsprintf$FUNC
    );
    static final FunctionDescriptor __msvcrt_fprintf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle __msvcrt_fprintf$MH = RuntimeHelper.downcallHandleVariadic(
        "__msvcrt_fprintf",
        constants$5.__msvcrt_fprintf$FUNC
    );
    static final FunctionDescriptor __msvcrt_printf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle __msvcrt_printf$MH = RuntimeHelper.downcallHandleVariadic(
        "__msvcrt_printf",
        constants$5.__msvcrt_printf$FUNC
    );
    static final FunctionDescriptor __msvcrt_sprintf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle __msvcrt_sprintf$MH = RuntimeHelper.downcallHandleVariadic(
        "__msvcrt_sprintf",
        constants$5.__msvcrt_sprintf$FUNC
    );
    static final FunctionDescriptor __msvcrt_vfprintf$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle __msvcrt_vfprintf$MH = RuntimeHelper.downcallHandle(
        "__msvcrt_vfprintf",
        constants$5.__msvcrt_vfprintf$FUNC
    );
}


