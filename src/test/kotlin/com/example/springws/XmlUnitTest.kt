package com.example.springws

import org.junit.jupiter.api.Test
import org.xmlunit.assertj.XmlAssert.assertThat as assertThatXml

class XmlUnitTest {
  @Test
  fun `assertThatXml_valueByXPath should work`() {
    val xml = """
      <fruit>
        <color>yellow</color>
      </fruit>
    """
    assertThatXml(xml).valueByXPath("//color").isEqualTo("yellow")
  }
}