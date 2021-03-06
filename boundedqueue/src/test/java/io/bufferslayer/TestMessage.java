package io.bufferslayer;

/**
 * Created by tramchamploo on 2017/3/14.
 */
public class TestMessage extends Message {

  final int key;
  private TestMessage(int key) {
    this.key = key;
  }

  static TestMessage newMessage(int key) {
    return new TestMessage(key);
  }

  static class Key extends MessageKey {

    final int key;
    Key(int key) {
      this.key = key;
    }

    @Override
    public int hashCode() {
      return key;
    }

    @Override
    public boolean equals(Object obj) {
      Key other = (Key) obj;
      return this.key == other.key;
    }
  }

  @Override
  public MessageKey asMessageKey() {
    return new Key(this.key);
  }

  @Override
  public String toString() {
    return "TestMessage(" + id + ")";
  }
}
