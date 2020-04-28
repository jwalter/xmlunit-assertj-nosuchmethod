# XMLUnit and assertj incompatibility
This repository contains a Spring Boot application demonstrating an incompatibility between the XMLUnit and AssertJ versions specified in the Spring Boot bom for 2.3.0.M2, M3 and M4.

# Reproducing
The incompatibility we're demonstrating is triggered by calling XmlAssert.valueByXPath:
```
assertThat(validXml).valueByXPath(validXPath).isEqualTo(expected)
```
The error that occurs is:
```
java.lang.NoSuchMethodError: org.xmlunit.assertj.ValueAssert.describedAs(Ljava/lang/String;[Ljava/lang/Object;)Lorg/assertj/core/api/AbstractAssert;

	at org.xmlunit.assertj.ValueAssert.create(ValueAssert.java:68)
	at org.xmlunit.assertj.XmlAssert.valueByXPath(XmlAssert.java:202)
```

## M1 (assertj 3.14.0, XMLUnit 2.6.3)
valueByXPath works fine
## M2 (assertj 3.15.0, XMLUnit 2.6.3)
NoSuchMethodError
## M3 (assertj 3.15.0, XMLUnit 2.6.4)
NoSuchMethodError
## M4 (assertj 3.15.0, XMLUnit 2.6.4)
NoSuchMethodError

# Conclusion
In assertj 3.15.0, the describedAs method was moved from AbstractAssert to Descriptable. This changed the method return type in the byte code, thus introducing a runtime incompatibility.