package com.hp.bsc.testing.jmssender;

import java.lang.reflect.Array;

/**
 * Copied from ch.rtc.tech.util.BaUt_Format
 * 
 * @author franczat
 *
 */
public final class IzuUt_Format
{
    public static String getHexString(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; ++i)
        {
            int highDigit = (bytes[i] & 0xF0) >> 4;
            int lowDigit = bytes[i] & 0xF;
            hexChars[(i * 2)] = Character.forDigit(highDigit, 16);
            hexChars[(i * 2 + 1)] = Character.forDigit(lowDigit, 16);
        }
        return new String(hexChars);
    }

    public static byte[] getByteArray(char[] hexChars)
    {
        byte[] bytes = new byte[hexChars.length / 2];
        for (int i = 0; i < bytes.length; ++i)
        {
            int highDigit = Character.digit(hexChars[(2 * i)], 16);
            int lowDigit = Character.digit(hexChars[(2 * i + 1)], 16);
            highDigit = highDigit << 4 & 0xF0;
            bytes[i] = (byte) (highDigit + lowDigit);
        }
        return bytes;
    }

    public static byte[] getByteArray(String hexString)
    {
        return getByteArray(hexString.toCharArray());
    }

    public static String getArrayAsString(Object array)
    {
        StringBuilder sb = new StringBuilder();
        appendArray(array, sb);
        return sb.toString();
    }

    public static void appendArray(Object array, StringBuilder stringBuffer)
    {
        if ((array != null) && (array.getClass().isArray()))
        {
            int arrayLength = Array.getLength(array);
            stringBuffer.append("[");
            for (int i = 0; i < arrayLength; ++i)
            {
                Object element = Array.get(array, i);
                if ((element != null) && (element.getClass().isArray()))
                {
                    appendArray(element, stringBuffer);
                }
                else
                {
                    stringBuffer.append(element);
                }
                if (i >= arrayLength - 1) continue;
                stringBuffer.append(", ");
            }

            stringBuffer.append("]");
        }
        else
        {
            stringBuffer.append(array);
        }
    }
}
