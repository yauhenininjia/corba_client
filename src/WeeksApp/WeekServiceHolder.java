package WeeksApp;

/**
* WeeksApp/WeekServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Week.idl
* Saturday, November 19, 2016 3:15:01 PM MSK
*/

public final class WeekServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public WeeksApp.WeekService value = null;

  public WeekServiceHolder ()
  {
  }

  public WeekServiceHolder (WeeksApp.WeekService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WeeksApp.WeekServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WeeksApp.WeekServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WeeksApp.WeekServiceHelper.type ();
  }

}